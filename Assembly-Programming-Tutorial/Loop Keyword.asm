;LOOP KEYWORD
 
INCLUDE 'EMU8086.INC'
.MODEL SMALL
.STACK 100H
.DATA
    
.CODE
MAIN PROC
    
    
    
    ;FOR(INT I = N ; I >= 0 ; I--)
    
    MOV CX , 10
    
    TOP:
    ;STATEMENTS
    PRINTN "LOOP IS RUNNING"
    
    LOOP TOP  ; I-- ; I >= 0 
    
    
    PRINTN "LOOP IS ENDED"
    
    
    MOV AH , 4CH
    INT 21H
MAIN ENDP

END MAIN