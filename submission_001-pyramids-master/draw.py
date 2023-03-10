

# TODO: Step 1 - get shape (it can't be blank and must be a valid shape!)
def get_shape():
    my_list=["square","triangle","pyramid"]
    while True:
        shapes=input("Shape?: ").lower()    
        if shapes in my_list:
            return shapes 

# TODO: Step 1 - get height (it must be int!)
def get_height():
    while True:
        height=input("Height?: ")
        if height.isdigit():            #determines if characters in the string are digits
            if int(height) <= 80:       #this states that if the height is an integer
                return int(height)      #then it should return it as True.

# TODO: Step 2
def draw_pyramid(height, outline):
    if outline==False:              
        spaces=height-1              #[stored values]
        stars=1
#solid
        for i in range(height):             ##repeats code a specific number of times
            print(" "*spaces+"*"*stars)       #print out spaces and asterisk  
            spaces=spaces-1
            stars=stars+2           #[stored values]
        else:
            for i in range(height):             #repeats code a specific number of times
                for j in range(height-i):
                    print("",end="")
            else:
                print("",end="")
#outline          
    else:
        for outline in range(1,height+1):           #repeats code a specific number of times
                for colmn in range(1,2*height):
                    if outline+colmn==height+1 or colmn-outline==height-1 or outline == height:     #if the condition is true, it determines the height of each row and column
                        print("*",end="")                               #prints out the number of stars and spaces at the start of the shape
                    elif outline==height and colmn!=j:              #multiple condition to return the outline is true if the statement is not equal or returns false if is equal
                        print("*",end="")                            
                        j=j+2                                        #variable J is an integer
                    elif outline+colmn<height+1 or colmn-outline<height-1:     
                        print(end=" ")                                #print out the number of stars and spaces of the last column
                print()
                j=2                                          #[stored values]

# TODO: Step 3
def draw_square(height, outline):
    if outline==False:
        stars=1                                                  #[stored values]
#solid
        for i in range(1,height+1):                              #repeats code a specific number of times
            for space in range(0,(height-1)+1):                  
                print("*",end="")
                stars+=1
            stars=0
 
            print()
#outline
    else:
        for i in range(1,height+1):                             #repeats code a specific number of times
            for outline in range(1,height+1):
                if i ==1 or i ==height or outline==1 or outline==height:
                    print("*",end="")
                else:
                    print(" ",end="")
            print()
    

# TODO: Step 4
def draw_triangle(height, outline):
    if outline == False:
        stars=1                                             #[stored values]
#solid
        for i in range(1,height+1):                         #repeats code a specific number of times
            for j in range(i+0):
                print("*", end="")
            else:
                 print("\n",end="")
            stars+=1
        stars=0                                              #[stored values]
 #outline       
    else:
        for outline in range(height):
            for j in range(height):                         #repeats code a specific number of times
                if j ==0 or outline ==height-1 or outline ==j:         
                    print("*",end="")
                elif j < outline:
                    print(" ",end="")
            print()

#Draw own shapes:
    #First shape:
def draw_upside_down_triangle(height,outline):
    height=int(input("height:"))
    for i in range(height,0,-1):
        print(" "*(height-i)+"* "*i)
    print()

    #Second shape:
def draw_diamond(height,outline):

    for i in range(1,height+1):
        print(" "*(height-i)+"* "*i)
    for i in range(height,0,-1):
        print(" "*(height-i)+"* "*i)
    print()

    #Third shape
def draw_half_diamond(height,outline):  
    for i in range(1,height+1):
        print("* "*i)
    for i in range(height,0,-1):
        print("* "*i)


# TODO: Steps 2 to 4, 6 - add support for other shapes
def draw(shape, height, outline):
        if shape=="pyramid":
            draw_pyramid(height, outline)
        elif shape=="square":
            draw_square(height, outline)
        elif shape=="triangle":
            draw_triangle(height, outline)
        elif shape=="upside down triangle":
            draw_upside_down_triangle(height, outline)
        elif shape=="diamond":
            draw_diamond(height, outline)
# TODO: Step 5 - get input from user to draw outline or solid
def get_outline():
    while True:
        outline_param=input("Outline only:(y/N) ").lower()
        if outline_param == 'n' or outline_param == '':
            return False
        elif outline_param == 'y':
            return True     

if __name__ == "__main__":
    shape_param = get_shape()
    height_param = get_height()
    outline_param = get_outline()
    draw(shape_param, height_param, outline_param)

