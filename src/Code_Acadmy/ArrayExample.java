package Code_Acadmy;

import java.util.ArrayList;

class ArrayExample {

    public static void main(String[] args) {
        ArrayList<String> desertIslandPlaylist = new ArrayList<String>();
        desertIslandPlaylist.add("Sneaker Pimps - Six Underground 1");
        desertIslandPlaylist.add("Sneaker Pimps - Six Underground 2");
        desertIslandPlaylist.add("Sneaker Pimps - Six Underground 3");
        desertIslandPlaylist.add("Sneaker Pimps - Six Underground 4");
        desertIslandPlaylist.add("Sneaker Pimps - Six Underground 5");
        System.out.println(desertIslandPlaylist);
        System.out.println("size of array list is: " + desertIslandPlaylist.size());
        desertIslandPlaylist.remove(4);
        System.out.println("size of arrayList after remove : "+ desertIslandPlaylist.size());
        System.out.println(desertIslandPlaylist);
        System.out.println("--------------------------------------------------------------------------------------------------");

        int a = desertIslandPlaylist.indexOf("Sneaker Pimps - Six Underground 4");
        int b = desertIslandPlaylist.indexOf("Sneaker Pimps - Six Underground 3");
        String tempA = desertIslandPlaylist.get(a);
        String tempB = desertIslandPlaylist.get(b);
        desertIslandPlaylist.set(a, tempB);
        desertIslandPlaylist.set(b,tempA);
        System.out.println(desertIslandPlaylist);


    }

}