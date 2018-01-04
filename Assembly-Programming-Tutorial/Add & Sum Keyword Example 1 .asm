;Input A , B
;Output A + B


.MODEL SMALL
.STACK 100H
.DATA
;THE VARIABLE WHICH ARE DECLARED
    A DB ?
    B DB ?   
    
.CODE
;CODE SEGMENT
MAIN PROC ; INT MAIN
    ;CODE STATEMENT
    
    MOV AH , 1
    INT 21H
    
    ;INSTRUCTION DESTINATION , SOURCE
    MOV A , AL 
    SUB A , 48 ; A = A - 48
    
    INT 21H
    MOV B , AL
    SUB B , 48 ; B = B - 48
    
    MOV BH , A ; BH = A
    ADD BH , B ; BH = BH + B
    ADD BH , 48 ; BH = BH + 48
    
    ;NEW LINE
    MOV AH , 2
    MOV DL , 0AH
    INT 21H
    MOV DL , 0DH
    INT 21H
    
    ;OUTPOUT OF THE SUM A+B
    MOV DL , BH
    INT 21H
    
     
    MOV AH , 4CH 
    INT 21H
    MAIN ENDP
END MAIN ; RETURN 0
    
    
    