#Cube
##A Rubik's Cube API
Given a cube in the format specified, a face to rotate, and a rotation direction - will return the resulting cube with the rotation applied. 

###Cube DSL
A cube object is composed of 6 faces each of which are defined as a nine character string. 
Each character represents a position in each face (see Fig. 1)

| X | X | X |  
| X | X | X |  
| X | X | X | 
 
_Figure 1_

Each X in the figure can be configure with any representation of six face colors. 
In this example the following hash will be used: 

| Key | Color |


-  0 - white  
-  1 - blue  
-  2 - green  
-  3 - orange  
-  4 - yellow  
-  5 - red  

Each face string can be built as follows: 

```
topLeftColor + topMidColor + topRightColor + 
midLeftColor + midMidColor + midRightColor + 
botLeftColor + botMidColor + botRightColor
```
Example: 

"111333333" represents a face composed of a blue top row then two orange rows. 
 
A face can be one of six faces corresponding to the following reference 
- 0 - top
- 1 - left
- 2 - right
- 3 - front
- 4 - bottom
- 5 - back

A direction can be one of two options:  
- 0 - CW or clockwise
- 1 - CCW or counter clockwise

###Sample JSON Request
```json
{
 "cube": {
  "top": "000000000",
  "left": "111111111",
  "right": "222222222",
  "front": "333333333",
  "bottom": "444444444",
  "back": "555555555"
},
 "face": "0",
 "direction": "0"
}
```

###Sample JSON Response
```json
{
  "top": "000000000",
  "left": "333111111",
  "right": "555222222",
  "front": "222333333",
  "bottom": "444444444",
  "back": "111555555"
}
```