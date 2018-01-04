;NESTED LOOP
                  
;****
;****
;****
;****

 
INCLUDE 'EMU8086.INC'
.MODEL SMALL
.STACK 100H
.DATA
    N DB ?
            
.CODE
MAIN PROC
    
    MOV AX , @DATA
    MOV DS , AX
    
    MOV AH , 1
    INT 21H
    SUB AL , 48
    MOV N , AL
    
    MOV BH , 1 ; INT I = 1
    PRINTN
    MOV AH , 2 
    MOV DL , '*'
    
    MOV CH , N
            
    LOOP1:
        CMP BH , N
        JG LOOP1_EXIT
        MOV BL , 1 ; INT J = 1
        LOOP2:
            
            CMP BL , CH 
            JG LOOP2_EXIT
            INT 21H
            INC BL ; BL++ ; J++
            JMP LOOP2
            
        LOOP2_EXIT:
        PRINTN
        INC BH ; BH++ ; I++
        DEC CH
        JMP LOOP1
    LOOP1_EXIT:  
    
    MOV AH , 4CH
    INT 21H
MAIN ENDP

END MAIN