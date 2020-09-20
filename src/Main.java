import Objects.Person;
import Objects.Polynomial;
import mainPackage.List;
public class Main {

    public static void main(String[] args) {
        Lab1();
        Lab2();
    }
    static void Lab1(){
        System.out.println("Задание №1.1");
        List<Polynomial> s = new List<>();
        List<Polynomial> p = new List<>();
        List<Polynomial> r = new List<>();
        p.add(new Polynomial(3,6));
        p.add(new Polynomial(2,4));
        r.add(new Polynomial(3,6));
        r.add(new Polynomial(2,4));
        System.out.println("Многочлены одинаковы: "+Equality(p,r));
        r.add(new Polynomial(6,4));
        System.out.println("Многочлены одинаковы(после добавления элемента в список r): "+Equality(p,r));
        Add(s,p,r);
        System.out.print("Многочлен s: ");
        for(int i = 0; i<s.size(); i++){
            s.get(i).ToString();
        }
        System.out.println("\nСумма всех членов многочлена s при x = 2: " + Meaning(s,2));
    }
    static void Lab2(){
        System.out.print("\nЗадание №1.3\n");
        List<Person>book = new List<>();
        book.add(new Person("Даркхолмович Иван Васильевич", 2991931));
        book.add(new Person("Миранович Дмитрий Владимирович", 1998003));
        book.add(new Person("Михаленко Даниил Власович", 3219982));
        book.add(new Person("Харритонович Билли Власович", 0));
        for(int i = 0; i<book.size(); i++){
            book.get(i).ToString();
        }
        searchNumber(book, "Даркхолмович");
        searchNumber(book, "Харритонович");
        searchSurname(book, 2991931);
        lexicographicSort(book);

    }

    //Сложение двух многочленов
    public static void Add(List<Polynomial> p, List<Polynomial> q, List<Polynomial> r) {
        for(int i = 0; i<q.size(); i++){
            p.add(q.get(i));
        }
        for(int i = 0; i<r.size(); i++){
            p.add(r.get(i));
        }
        Fix(p);
        BubbleSort(p);
    }

    //Сортировка списка по степени
    static void BubbleSort(List<Polynomial> list) {
        for(int i = list.size()-1; i>0; i--)
        for (int j = 0; j < i; j++) {
            Polynomial temp = list.get(j);
            if (list.get(j).getX() < list.get(j + 1).getX()) {
                list.set(list.get(j+1), j);
                list.set(temp, j+1);
            }
        }
    }

    //Поиск всех элементов в списке с одинаковыми степенями с последующим их сложением
    static void Fix(List<Polynomial> list) {
        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < list.size(); j++) {
                if (j == i)
                    continue;
                if (list.get(i).getX() == list.get(j).getX()) {
                    list.get(i).setA(list.get(i).getA() + list.get(j).getA());
                    list.get(i).setX(list.get(i).getX());
                    list.remove(j);
                }
            }
    }

    //Проверка равенства многочленов
    public static boolean Equality(List<Polynomial> p, List<Polynomial> r) {
        if (p.size() == r.size()) {
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i).getA() != r.get(i).getA() && p.get(i).getX() != r.get(i).getX()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //Вычисление многочлена в данной координате
    public static int Meaning(List<Polynomial> p, int x) {
        int sum = 0;
        for(int i = 0; i<p.size(); i++){
            Polynomial part = p.get(i);
            int degree = (int)Math.pow(x,part.getX());
            sum+= degree*part.getA();
        }
        return sum;
    }

    //Методы для задания №1.3

    //Сортировка по алфавитному порядку
    static void lexicographicSort(List<Person>list) {
        for (int i = list.size()-1; i > 0; i--)
            for (int j = 0; j < i; j++) {
                Person temp = list.get(j);
                char fLetter = list.get(j).getPersonInfo().charAt(0);
                char sLetter = list.get(j + 1).getPersonInfo().charAt(0);
                if (indexInAlphabet(fLetter) > indexInAlphabet(sLetter)) {
                    list.set(list.get(j + 1), j);
                    list.set(temp, j + 1);
                }
            }
    }

    //Поиск номера в алфавите
    private static int indexInAlphabet(char letter){
        char []Alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
        int index = 0;
        for(int i = 0; i<Alphabet.length; i++)
            if(Alphabet[i] == letter){
                index = i;
                break;
            }
        return index;
    }

    //Поиска фамилии по номеру телефона
    public static void searchSurname(List<Person> list, int number){
        for(int i = 0; i< list.size(); i++){
            if(list.get(i).getNumber() == number){
                System.out.printf("Фамилия по номеру телефона(%d): %s\n",number ,findSurname(list.get(i).getPersonInfo()));
                break;
            }
        }
    }

    //Поиск номера телефона по фамилии
    public static void searchNumber(List<Person> list, String name){
        for(int i = 0; i<list.size(); i++){
            if(findSurname(list.get(i).getPersonInfo()).equalsIgnoreCase(name)){
                System.out.printf("Номер телефона по фамилии(%s): %d\n",name,list.get(i).getNumber());
                break;
            }
        }
    }

    public static String findSurname(String ID){
        String []mas = ID.split("[ ]+");
        return mas[0];
    }
}
