/* Задание 5 практика 2 блок 1 */
public class S5 {

    static class Dog {

        private String name;
        private int age;

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getHumanAge() {
            return age * 7;
        }

        public String toString() {
            return "Собака " + name + ", возраст " + age + " (по человеческим меркам " + getHumanAge() + ")";
        }
    }

    static class DogKennel {

        private Dog[] dogs;
        private int count;

        public DogKennel(int size) {
            dogs = new Dog[size];
            count = 0;
        }

        public void addDog(Dog dog) {
            if (count < dogs.length) {
                dogs[count] = dog;
                count++;
            } else {
                System.out.println("В питомнике нет мест");
            }
        }

        public void printAll() {
            for (int i = 0; i < count; i++) {
                System.out.println(dogs[i]);
            }
        }
    }

    public static void main(String[] args) {
        DogKennel kennel = new DogKennel(4);

        kennel.addDog(new Dog("Пушистик", 4));
        kennel.addDog(new Dog("Чертик", 2));
        kennel.addDog(new Dog("Шарик", 9));

        System.out.println("Собаки в питомнике:");
        kennel.printAll();

        Dog dog = new Dog("Мухтар", 3);
        System.out.println("Кличка: " + dog.getName());
        System.out.println("Возраст: " + dog.getAge());
        dog.setAge(4);
        System.out.println("После изменения возраста: " + dog);
    }
}
