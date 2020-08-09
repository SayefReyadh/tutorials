;HOW TO WRITE CUSTOM FUNCTIONS?

INCLUDE 'EMU8086.INC'
.MODEL SMALL
.STACK 100H
.DATA

.CODE        

MAIN PROC 
    
    
    CALL FUNCTION_NAME
    
    PRINTN "I am the Main Function"
          
     
    MOV AH , 4CH 
    INT 21H
    MAIN ENDP

    
    FUNCTION_NAME PROC
         ;STATEMENT
         ;STATEMENT
         PRINTN "HELLO WORLD"
         PRINTN "HELLO I am a Function"
         
         
         RET
    FUNCTION_NAME ENDP   

END MAIN 
    
    
    
