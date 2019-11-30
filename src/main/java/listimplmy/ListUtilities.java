package listimplmy;

public class ListUtilities {
    public static void display(IList list){
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
}
