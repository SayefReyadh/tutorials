;-----------
; getstr.asm
;
; This is a simple demo for emu8086
;
; This program reads a string of at most 32
; characters from keyboard, and prints it back.
; A new-line (return character) would mark
; the end of string.
; The size of buffer is an adjustable constant

; multi-segment executable file template.

data segment
    ; add your data here!

; the maximum size of string
strsize= 32

; the buffer to save the entered string    
mystr   db  strsize dup (?)

        ; 3 extra places to store return/new-line and '$'
        ; for printing
        db  3 dup (?) 

; prompts
msg1    db  "Enter a string (maximum $"
msg2    db  " characters long): $"
msg3    db  "String Length: $"

; endl squence         
endl    db  13, 10 , '$'    

    pkey db "press any key...$"
ends

stack segment
    dw   128  dup(0)
ends

code segment
start:
; set segment registers:
    mov ax, data
    mov ds, ax
    mov es, ax

    ; add your code here 

    ; print msg1
    lea     dx, msg1
    mov     ah, 9
    int     21h

    ; print the buffer size
    mov     ax, strsize
    call    printd         

    ; print msg2 (the tail of msg1)
    lea     dx, msg2
    mov     ah, 9
    int     21h

    ; call getstr to read a string from keyboard    
    mov     cx, strsize
    mov     dx, offset mystr
    call    getstr 

    ; print an endl before going on    
    lea     dx, endl
    mov     ah, 9
    int     21h 

    ; print msg3
    lea     dx, msg3
    mov     ah, 9
    int     21h

    ; first print the legth of string
    mov     ax, cx
    call    printd

    ; then print the string itself                                     
    mov     dx, offset endl
    mov     ah, 9
    int     21h

    ; print the read string    
    mov     dx, offset mystr
    mov     ah, 9
    int     21h

    ; wait for user to press a key.    

    lea dx, pkey
    mov ah, 9
    int 21h        ; output string at ds:dx

    ; wait for any key....    
    mov ah, 1
    int 21h

    mov ax, 4c00h ; exit to operating system.
    int 21h    

;--------------------
; Function printd
; prints the value of AX register in signed
; decimal format.
;
; This function uses a recursive algorithm to print
; The value in AX register. For example, to print the
; value 3187, this function call itself (printd)
; for 318, then prints 7.
; If the value to print is less than 10, then it is 
; printed and recursion terminates.
; If the value is negative, a - is printed then 
; printd is called for the negate of value.

printd  proc

    ; preserve used registers
    push    ax  
    push    bx
    push    cx    
    push    dx

    ; if negative value, print - and call again with -value     
    cmp     ax, 0
    jge     L1

    mov     bx, ax

    ; print -    
    mov     dl, '-'
    mov     ah, 2
    int     21h   

    ; call with -AX             
    mov     ax, bx
    neg     ax
    call    printd
    jmp     L3

L1:

    ; divide ax by 10
    ; ( (dx=0:)ax / cx(= 10) )
    mov     dx, 0
    mov     cx, 10
    div     cx

    ; if quotient is zero, then print remainder              
    cmp     ax, 0
    jne     L2

    ; DX contains the remainder, but since DX < 10;
    ; actually DL contains it. In order to print it
    ; In ASCII format, we should add '0' to it.
    ; For example, the ascii code of 5 is 53,
    ; and the ascii code of '0' is 48. In order to
    ; print 5, we add '0' to it to make it '5'.
    add     dl, '0'
    mov     ah, 2
    int     21h

    jmp     L3

L2: 
    ; if the quotient is not zero, we first call
    ; printd again for the quotient, and then we
    ; print the remainder.

    ; call printd for quotient:
    call    printd             

    ; print the remainder
    add     dl, '0'
    mov     ah, 2
    int     21h        

L3:
    ; recover used registers
    pop     dx
    pop     cx
    pop     bx
    pop     ax
    ret
printd  endp

;--------------------
; Function printud
; prints the value of AX register in unsigned
; decimal format.
;
; This function uses a recursive algorithm to print
; The value in AX register. For example, to print the
; value 3187, this function call itself (printud)
; for 318, then prints 7.
; If the value to print is less than 10, then it is 
; printed and recursion terminates.

; The comments are exactly like printd. We just dropped
; the code for negative case. There is no negative case
; for unsigned integer: -1 is assumed 65535.                           
printud  proc
    push    ax  
    push    bx
    push    cx    
    push    dx

    mov     dx, 0
    mov     cx, 10
    div     cx

    cmp     ax, 0
    jne     L4

    add     dl, '0'
    mov     ah, 2
    int     21h

    jmp     L5

L4:
    call    printud
    add     dl, '0'
    mov     ah, 2
    int     21h        

L5:
    pop     dx
    pop     cx
    pop     bx
    pop     ax
    ret
printud  endp

;--------------------
; Function getstr
;
; getstr reads a string from keyboard. The size of buffer
; (the maximum character to read) is in CX register.
; The buffer must have 3 more rooms to save the 
; return/new-line/$ sequence.
; The input string may not contain a $ character because
; that would force the MS-DOS I/O to terminate the printing.
; (Just test it!)
; DX contains the address of buffer in memory
; In return, CX would have the number of bytes actually read.

getstr      proc

            ; preserve used register
            push    ax
            push    bx
            push    si

            ; si used as base address
            mov     si, dx

            ; bx used as index to the base address
            mov     bx, 0

; It is a bit funny because I used BX as index and 
; si as base address (Names si: source index, 
; bx: base register), but it doesn't really matter.
; It just reduces the readability of the code 
; slightly             

            ; It is a loop                      
L11:        
            ; read next character
            mov     ah, 1
            int     21h

            ; Check if it is not return 
            ; (indicating the end of line)                                 
            cmp     al, 13 ; return character
            jz      L12

            ; save the read character in buffer.
            mov     [si][bx], al

            ; next index of buffer
            inc     bx

L12:
            ; loop until count-down is zero and not 
            ; matched return character            
            loopnz  L11

            ; bx contains the length of string.
            ; save it in cx                          
            mov     cx, bx

            ; append a sequence of return, 
            inc     bx
            mov     [si][bx], 13                                                                  

            ; new-line and                               
            inc     bx
            mov     [si][bx], 10                                                                  

            ; '$' character to the string          
            inc     bx
            mov     [si][bx], '$'                                                                  

            ; recover used register          
            pop     si
            pop     bx
            pop     ax
            ret
getstr      endp

;--------------------

ends

end start ; set entry point and stop the assembler.