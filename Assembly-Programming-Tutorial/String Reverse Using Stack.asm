INCLUDE 'EMU8086.INC'
.MODEL SMALL
.STACK 100H
.DATA

.CODE        

MAIN PROC 
    
    
    PRINT "ENTER : "
    
    MOV AH , 1
    
    XOR CX , CX
    
    INPUT:
        INT 21H
        CMP AL , 0DH
        JE EXIT_INPUT
        PUSH AX            
        INC CX
        JMP INPUT
    EXIT_INPUT:
    
    PRINTN
    PRINT "OUTPUT : "
    MOV AH , 2
    
    OUTPUT:
        POP DX
        INT 21H    
    LOOP OUTPUT
        
    MOV AH , 4CH 
    INT 21H
    MAIN ENDP
END MAIN 
    
    
    