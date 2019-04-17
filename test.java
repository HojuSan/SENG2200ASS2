public class test
{
    public static void main (String[] args) 
    {
        System.out.println("start");
        LinkedList list = new LinkedList();
        System.out.println("finish");
        int a =1;
        int b =2;
        int c =3;
        list.prepend(a);
        list.prepend(b);
        list.append(5);
        list.prepend(c);
        list.append(5);
        list.append(4);
        System.out.print(list.printList());
        System.out.println("finish");

    }//end of Main 

}//end of test class