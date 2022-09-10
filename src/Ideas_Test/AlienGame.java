package Ideas_Test;
public class AlienGame {
    static int[] health;
    static int[] gender;

    public static void main(String[] args) {
        int many = 71;
        health = new int[many];
        gender = new int[many];
        generatePopulation(71);

        if (gender[13] == 0 && gender[28] == 0){
            //no mating
        }else if (gender[13] == 1 && gender[28] == 1){
            //no mating
        }else {
            int p_reproduce = (health[13] + health[28]) / many;
        }

        int id1 = (int) (Math.random() * many);
        int id2 = (int) (Math.random() * many);

        int countmale = 0;
        int countfemale = 0;
        for (int i = 0; i < many; i++) {
            int he = health[i];
            if (health[i] > he){
                he = health[i];
            }
            System.out.println("highest health in the popluatin is: " +  he);

            int he1 = 0;
            if (health[i] < he1){
                he1 = health[i];
            }
            System.out.println("loest.... is" + he1);
            if (gender[i] == 0){
                countmale++;
            }else
                countfemale++;
        }

        System.out.println("female popluation with: " + countfemale/many);
    }

    public static void generatePopulation(int many){
        for (int i = 0; i < many ; i++) {

            String[] genetic = new String[128];
            for (int j = 0; j < 128; j++) {
                int random = (int) (Math.random() * 3);  // generate number between 0 and 2
                if (random == 0) {
                    genetic[j] = "x";
                } else if (random == 1) {
                    genetic[j] = "y";
                } else {
                    genetic[j] = "z";
                }
            }

            int hp = 0;
            for (int o = 0; o < 126; o++) {
                String c = genetic[i] + genetic[i + 1] + genetic[i + 2];
                if (c == "yxz" || c == "yzx") {
                    hp++;
                }
            }

            health[i] = hp;


            String gend = genetic[127];
            if (gend == "y") {
                gender[i] = 0;  //male
            } else
                gender[i] = 1; //female
        }

    }
}
