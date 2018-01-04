;------------
; arraysum.asm
; This is a demo program for emu 8086
;
; This program adds two array of fixed size
; elemeny by element ad saves the result
; in the third array: (Array3 = Array1 + Array2)
;
; In display, Array1 and Array2 are displayed
; and then sum (as the third array)  is printed.
;
; We use the printd function. printd prints
; the value of AX, Here, we are dealing with
; bytes: al contains the value to print, so, we
; extends al to ax by putting 0 in ah (ah = 0)
;
; printd prints the value of AX register as
; a 16-bit signed integer.
;
; The main program of this demo simply prints
; Array1 and Array2 element by element, and then
; prints Array3 (while calculating the sums) element
; by element.

; multi-segment executable file template.

data segment
    ; add your data here!

; Memory variables    

; Size of the array. Note: arrSize should match
; the number of bytes db'ed (byte-defined) for
; Array1 and Array2
arrSize = 6        

; Arrays
Array1  db  10, 12, 14, 20, 13, 7
Array2  db  29, 12, 0, 33, 100, 44

; Array3 is not initialized
Array3  db  arrSize dup (?)

; prompts and messages                           
msg1    db  "Array 1: $"
msg2    db  "Array 2: $"
msg3    db  "Sum     : $"

; endl : string of return + new-line
endl    db  10, 13, '$'

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

    ; print msg1
    lea     dx, msg1
    mov     ah, 9
    int     21h

    ; Use loop to print the values of Array1                
    mov     cx, arrSize
    mov     bx, 0

L1001:

    mov     al, Array1 [bx]
    ; Extend (unsigned) AL to AX (to print)    
    mov     ah, 0
    call    printd

    mov     ah, 2
    mov     dl, 09 ;TAB Character
    int     21h

    inc     bx
    loop    L1001 

    ; print endl after Array1    
    lea     dx, endl
    mov     ah, 9
    int     21h

    ; print msg2     
    lea     dx, msg2
    mov     ah, 9
    int     21h

    ; Use loop to print values of Array2                
    mov     cx, arrSize
    mov     bx, 0

L1002:

    mov     al, Array2 [bx]
    ; Extend (unsigned) AL to AX (to print)    
    mov     ah, 0
    call    printd

    mov     ah, 2
    mov     dl, 09 ;TAB Character
    int     21h

    inc     bx
    loop    L1002

    ; print two endl's
    lea     dx, endl
    mov     ah, 9
    int     21h

    lea     dx, endl
    mov     ah, 9
    int     21h

    ; print msg3    
    lea     dx, msg3
    mov     ah, 9
    int     21h     

    ; calculate sum's element by elements
    ; and print each sum using a loop                
    mov     cx,  arrSize
    mov     bx, 0

L1003:
    mov     al, Array1 [bx]
    add     al, Array2 [bx]
    mov     Array3 [bx], al

    ; Extend (unsigned) AL to AX (to print)    
    mov     ah, 0
    call    printd

    ; print TAB
    mov     ah, 2
    mov     dl, 09 ;TAB Character
    int     21h

    inc     bx
    loop    L1003    

    ; print endl    
    lea     dx, endl
    mov     ah, 9
    int     21h

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

ends

end start ; set entry point and stop the assembler.