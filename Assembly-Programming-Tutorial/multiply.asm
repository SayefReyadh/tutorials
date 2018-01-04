;------------
; muldemo.asm
; This is a demo program for emu 8086
; 
; This demo reads two unsigned 16-bit
; integer values (words) from keyboard and
; prints their product.
;
; In this demo the function readint is defined
; to read a 16-bit unsigned integer value (word).
; If the number entered by user is too big,
; it prints an error message.
;
; In this program we use our defined function
; printud to print the product.
;
; printud prints the value of AX register as
; a 16-bit unsigned integer (word).
;
; The main program of this demo gets two words
; from key board and saves them in value1 and
; value2 respectively, then it calculates the
; product. If the product has overflow (dx > 0)
; then an overflow message is printed. Otherwise,
; the value of product is printed.
; We have used various prompts and messages to
; support a user-friendly interaction.

; multi-segment executable file template.

data segment
    ; add your data here!

; Memory variables
value1  dw  24
value2  dw  35
value3  dw  ?

prompt1     db  "Enter two integers: $"
product     db  "Product = $"
interror    db  13, 10, "Number is too big!", 13, 10, '$'
mulerror    db  13, 10, "Multiplication overflow!", 13, 10, '$'

; endl : string of return + new-line
endl    db  13, 10, '$'

; a string to keep prompt visible
pkey    db "press any key...$"
ends

stack segment
    dw   128  dup(0)
ends

code segment

;--------------------
; MAIN PROGRAM
start:
; set segment registers:
    mov ax, data
    mov ds, ax
    mov es, ax

    ;--------------------
    ; add your code here 

    ; Print prompt1
    lea     dx, prompt1
    mov     ah, 9
    int     21h

    ; Read first int, if it is too large, error message.
    call    readint
    cmp     dx, 0
    jne     L1001

    ; Save the number in value1
    mov     value1, ax

    ; Read the second int, if it is too large, error message.
    call    readint
    cmp     dx, 0
    jne     L1001

    ; Save the number in value2
    mov     value2, ax

    ; print a return/new-line char.
    lea     dx, endl
    mov     ah, 9
    int     21h

    ; perform the multiplication
    mov     ax, value1
    mul     value2

    ; If the result is too big, error message.
    cmp     dx, 0
    jne     L1002

    ; save the product in value3
    mov     value3, ax

    ; print the message
    lea     dx, product
    mov     ah, 9
    int     21h

    ; print the product result                       
    mov     ax, value3
    call    printud

    ; print return/new-line
    lea     dx, endl
    mov     ah, 9
    int     21h

    ; goto end
    jmp     L1000

    ; print number too large error
L1002:
    lea     dx, mulerror
    mov     ah, 9
    int     21h
    jmp     L1000

    ; print multiplication overflow error
L1001:
    lea     dx, interror
    mov     ah, 9
    int     21h

L1000:

    ;--------------------
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
; Function readint
;
; Reads an integer from keyboard.
; IF OK, AX contains the value (DX = 0)
; Otherwise, DX > 0 and number is too large.

readint proc 
    ; preserve the used registers
    push    bx
    push    cx

    ; bx contains the number entered so far.
    ; It is initially 0
    mov     bx, 0      

    ; dx indicates if there is overflow.
    mov     dx, 0

L12:    
    ; reads a character from keyboard
    mov     ah, 1
    int     21h                      

    ; Checks if it is a valid numeric key.
    cmp     al, '0'
    jb      L11
    cmp     al, '9'
    ja      L11

    ; if it is valid, convers fro ascii to integer,                                          
    sub     al, '0'
    mov     ah, 0

    ; multiples the number read so far by 10 and adds 
    ; the new value to it
    xchg    ax, bx
    mov     cx, 10

    mul     cx

    ; If there is a overflow, exits the function 
    ; with dx > 0                         
    cmp     dx, 0
    jne     L11

    ; Otherwise, saves the number so far in bx
    add     bx, ax                            

    ; Goes for another key.
    jmp     L12

L11:
    ; If for any reason input terminates,
    ; that is, either user enters a white
    ; separator or the number is too large,
    ; we are here: move the number read so far
    ; to ax and returns.    
    mov     ax, bx

    ; recover used registers        .
    pop     cx
    pop     bx
    ret
readint endp
;--------------------

ends

end start ; set entry point and stop the assembler