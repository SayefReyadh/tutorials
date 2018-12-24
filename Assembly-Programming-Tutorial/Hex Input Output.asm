INCLUDE 'EMU8086.INC'
.MODEL SMALL
.STACK 100H
.DATA

.CODE        

MAIN PROC 
    
    MOV BX , 0
    MOV CL , 4
    ;PRINT "ENTER HEX NUMBER : "
    MOV AH , 1
    FOR1:
        INT 21H
        CMP AL , 0DH
        JE  END_FOR
        
        CMP AL , 41H
        JGE LETTER
        
        ;DIGIT
        SUB AL , 48
        JMP SHIFT
        
        LETTER:
            SUB AL , 37H
        
        SHIFT:
            SHL BX , CL ; NEW SPACE TO STORE
            OR BL , AL
        JMP FOR1
        
    END_FOR:
    
    PRINTN 

    ;XOR CH , CH
    MOV CX , 4
    MOV AH , 2
    
    FOR2:
        MOV DL , BH
        SHR DL , 4
        SHL BX , 4
        
        CMP DL , 10
        JGE LETTER2
        
        ;DIGIT
        ADD DL , 48
        INT 21H
        JMP END_OF_LOOP2
        
        LETTER2:
        ADD DL , 55
        INT 21H    
        
        END_OF_LOOP2:
    LOOP FOR2
             
    MOV AH , 4CH 
    INT 21H
    MAIN ENDP
END MAIN 
    
    
    