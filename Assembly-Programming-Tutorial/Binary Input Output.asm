;Write a program to take input in binary

INCLUDE 'EMU8086.INC'
.MODEL SMALL
.STACK 100H
.DATA
    COUNT DB 0
.CODE        

MAIN PROC 
    
    
    ;CLEAR A REGESTIR BX TO STORE THE DATA
    ;LOOP START
    ;INPUT 0/1
    ;CHECK IF IT'S ENTER?
    ;IF ENTER END LOOP 
    ;BX SHL
    ;STORE THE INPUT BX REGISTER LSB BIT  
    
    MOV AX , @DATA
    MOV DS , AX
    
    MOV BX , 0
    
    MOV AH , 1
    FOR1:
        INT 21H
        CMP AL , 0DH
        JE END_FOR1
        SUB AL , 48
        SHL BX , 1
        OR BL , AL
        INC COUNT
        JMP FOR1    
    END_FOR1:
 
    PRINTN
    MOV CL , 16
    SUB CL , COUNT
    RCL BX , CL
    
    XOR CH , CH
    MOV CL , COUNT
    
    MOV AH , 2
    
    FOR2:
    
        RCL BX , 1
        JC OUTPUT_ONE
        MOV DL , '0'
        INT 21H
        JMP LAST_OF_LOOP
        
        OUTPUT_ONE:
        MOV DL , '1'
        INT 21H
        
        LAST_OF_LOOP:
    LOOP FOR2
     
    MOV AH , 4CH 
    INT 21H
    MAIN ENDP
END MAIN 
    
    
    