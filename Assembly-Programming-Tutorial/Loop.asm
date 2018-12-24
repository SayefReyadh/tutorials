;LOOP USING JMP KEYWORD

; 1+2+3+....+N = ?
 
INCLUDE 'EMU8086.INC'
.MODEL SMALL
.STACK 100H
.DATA
    N DB ?
    SUM DB 0
        
.CODE
MAIN PROC
    
    MOV AX , @DATA
    MOV DS , AX
 
    PRINT "ENTER N:"
    MOV AH , 1
    INT 21H
    SUB AL , 48 ; CHAR + 48
    MOV N , AL
    
    
    
    PRINTN
    
    MOV BL , 1 ; INT I = 0
    
    TOP:
    CMP BL , N ; COMPARE
    JG EXIT_LOOP ; BL <= N
    ADD SUM , BL ; SUM = SUM + BL
    INC BL       ; BL++
    JMP TOP
    
    
    EXIT_LOOP:
    
    PRINTN "THE SUM IS "
    
    MOV AH , 2 
    MOV DL , SUM
    INT 21H   
    
    MOV AH , 4CH
    INT 21H
MAIN ENDP

END MAIN