import java.net.ServerSocket;

public class ServerDragons<T> {
        SimpleList classes = new SimpleList();
        SimpleList ages = new SimpleList();
        int tmp=100, dragons_num=100;
        java.util.Random random = new java.util.Random();



        public String random_classe() {
            String[] available_classe = {"Comandante", "Infantería", "Capitanes"};
            int ran_classe = random.nextInt(available_classe.length);
            if (available_classe[ran_classe].equals("Comandante")) {
                if (in((T) "Comandante", classes)) {
                    random_classe();
                } else {
                    classes.push(available_classe[ran_classe]);
                    return available_classe[ran_classe];
                }
            }return available_classe[ran_classe];
        }

        public int random_speed(){
            int speed = (int) (1 + (Math.random() * (100 - 1)));
            return speed;
        }

        public int random_resistance(){
            int resistance = (int) (1 + (Math.random() * (3 - 1)));
            return resistance;
        }

        public int random_age(){
            int age = (int) (1 + (Math.random() * (1000 - 1)));
            if (in(age, ages)){
                random_age();
            }else{
                ages.push(age);
                return age;
            }
            return age;
        }

        public boolean in(Object tosearch, SimpleList list){
            if (list.getSize()==0){
                return false;
            }else{
                for (int i = 0; i < list.getSize(); i++) {
                    if (tosearch == list.getNode(i).getData()) {
                        return true;
                    }
                }
            }
            return false;
        }



        public void generate(String wave){
            int dragons_num = ((20*tmp)/100)+tmp;
            this.tmp=dragons_num;
            for (int cont = 0; cont < dragons_num; cont++) {
                String name = wave  + String.valueOf(cont);
                System.out.println(name);
                Node dragon = new Node(random_speed(),random_age(),random_resistance(),random_classe(),name);
            }
        }

        public static void main(String a[]){
            ServerDragons serlet = new ServerDragons();
            serlet.generate("a");
        }
    }



