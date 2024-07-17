package src;

/*

Problem:- Rotate an array to the left or right direction by count k.

Example 1:

Input :- Array = [1,2,3,4,5,6,7], direction = left, k = 1
Output :- Array = [2,3,4,5,6,7,1]

Input :- Array = [1,2,3,4,5,6,7], direction = left,
Output :- Array = [3,4,5,6,7,1,2] // [6,7,1,2,3,4,5]

Input :- Array = [1,2,3,4,5,6,7], direction = left, k = 8
Output :- Array = [2,3,4,5,6,7,1]

Input :- Array = [1,2,3,4,5,6,7], direction = right, k = 3
Output :- Array = [5,6,7,1,2,3,4]

Input :- Array = [1,2,3,4,5,6,7], direction = right, k = 1
Output :- Array = [7,1,2,3,4,5,6]

Note: Treat array as a circular array where it can be rotated even if the number of rotations is more than the length of the array.
 */
public class EFS1 {

    public int[] rotate(int[] arr, String direction, int k)
    {
        k = k % arr.length;
       // int[] newArr = new int[arr.length];

        if(direction == "left")
        {
            int pointer1 = 0;
            int pointer2 = k-1;

            while(pointer1 < pointer2)
            {
                int temp = arr[pointer1];
                arr[pointer1] = arr[pointer2];
                arr[pointer2] = temp;
                pointer1++;
                pointer2--;
            }

            pointer1 = k;
            pointer2 = arr.length -1;
            while(pointer1 < pointer2)
            {
                int temp = arr[pointer1];
                arr[pointer1] = arr[pointer2];
                arr[pointer2] = temp;
                pointer1++;
                pointer2--;
            }

            pointer1 = 0;
            pointer2 = arr.length-1;
            while(pointer1 < pointer2)
            {
                int temp = arr[pointer1];
                arr[pointer1] = arr[pointer2];
                arr[pointer2] = temp;
                pointer1++;
                pointer2--;
            }
        }
        if(direction == "right")
        {
            int pointer1 = 0;
            int pointer2 = arr.length - k -1;

            while(pointer1 < pointer2)
            {
                int temp = arr[pointer1];
                arr[pointer1] = arr[pointer2];
                arr[pointer2] = temp;
                pointer1++;
                pointer2--;
            }

            pointer1 = arr.length - k ;
            pointer2 = arr.length -1;
            while(pointer1 < pointer2)
            {
                int temp = arr[pointer1];
                arr[pointer1] = arr[pointer2];
                arr[pointer2] = temp;
                pointer1++;
                pointer2--;
            }

            pointer1 = 0;
            pointer2 = arr.length-1;
            while(pointer1 < pointer2)
            {
                int temp = arr[pointer1];
                arr[pointer1] = arr[pointer2];
                arr[pointer2] = temp;
                pointer1++;
                pointer2--;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        EFS1 efs1  = new EFS1();
       int[] result = efs1.rotate(new int[]{1,2,3,4,5,6,7},"right",1);

       for(int i =0;i < result.length; i++)
           System.out.println(result[i]);
    }

}


//SQL Query

/*

Given following single employee Table, write a SQL query to get employee name and his manager’s name.

Table : Employees

emp_id | emp_name | manager_id
——————————————————
1	      |       A	        |	NULL
2	      |       B	        |	NULL
3	      |       C	        |	1
4	      |       D	        |	1
5	      |       E	        |	2


Expected Output:-

emp_name | manager_name
——————————————
A                 |  NULL
B                 |  NULL
C                 |  A
D                 |  A
E                 |  B

select emp_name,emp_name as manager_name from Employees where

select emp_name,emp_name as manager_name from Employees e1 join Employees e2 where e1.emp_id =e2.manager_id;


//How do make a class immutable
 */
 /*
class A
{
final String name;

public A a(String str)
{
this.name  = str;
}
 */

//Sort the list of users on the basis of name and city
//User(City, Name);
//List users;
//users.sort((user1, user2)) -> user1.city - user2.city);

//Difference between controller and restController
//BeanScope




