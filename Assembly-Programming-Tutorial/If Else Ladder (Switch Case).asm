;IF ELSE Ladder
;A number, >= 100 ? or >= 80 ? or >= 60 or >= 40 ? or >= 20 or less than 20
;>= 100 The Number is Greater or Equal to 100
 
INCLUDE 'EMU8086.INC'
.MODEL SMALL
.STACK 100H
.DATA

.CODE
MAIN PROC

    MOV BX , 100 ; RANDOM NUMBER
    
    CMP BX , 100 ;COMPARE >= 100
    JGE IF1
    
    CMP BX , 80  ;COMPARE  >= 80
    JGE IF2
    
    CMP BX , 60  ;COMPARE  >= 60
    JGE IF3
    
    CMP BX , 40  ;COMPARE  >= 40
    JGE IF4
    
    CMP BX , 20  ;COMPARE  >= 20
    JGE IF5
    
    JMP ELSE
       
    
    IF1:
    PRINTN "THE NUMBER IS GREATER OR EQUAL 100"
    ;JMP END_IF
    
    IF2:
    PRINTN "THE NUMBER IS GREATER OR EQUAL 80"
    ;JMP END_IF
    
    IF3:
    PRINTN "THE NUMBER IS GREATER OR EQUAL 60"
    ;JMP END_IF
    
    IF4:
    PRINTN "THE NUMBER IS GREATER OR EQUAL 40"
    ;JMP END_IF
    
    IF5:
    PRINTN "THE NUMBER IS GREATER OR EQUAL 20"
    ;JMP END_IF
    
    ELSE:
    PRINTN "THE NUMBER IS LESS THAN 20"
    ;JMP END_IF 
       
       
    END_IF:
    
    MOV AH , 4CH
    INT 21H
MAIN ENDP

END MAIN