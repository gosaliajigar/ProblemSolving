Problem Statement: 

In our product, users are encouraged to join missions which help them to make healthier lifestyles and to improve their fitness, diet, and overall health one step at a time. 

Employees have traditionally participated extensively in these missions. As our company grows (and the number of missions does, as well), it's becoming increasingly hard to tell how effective each mission is for each employee.

We need your help writing a program to get us one particular graph data point: for each mission, how many other missions are also undertaken by employees who participate in that one?

Here's an example (and how you can expect the incoming data to be formatted):
Mission ID Employee
    1        Sam
    2        Ilya
    2        Sue
    3        Megan
    4        Ilya
    5        Ilya
    5        Sue
    6        Sue
    7        Sam

Output:
Mission ID | # of other missions
    1      |       1
    2      |       3
    3      |       0
    4      |       2
    5      |       3
    6      |       2
    7      |       1

You can assume all employees will go by their first name only, and that each first name is unique.
