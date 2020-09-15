import Polyminial.Polynomial;
import com.company.List;
public class Main {

    public static void main(String[] args) {
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
    static void Fix(List<Polynomial> list){
        for(int i = 0; i<list.size(); i++)
            for(int j = 0; j<list.size(); j++){
                if(j == i)
                    continue;
                if(list.get(i).getX() == list.get(j).getX()){
                    list.get(i).setA(list.get(i).getA()+list.get(j).getA());
                    list.get(i).setX(list.get(i).getX());
                    list.remove(j);
                }
            }
    }
    public static boolean Equality(List<Polynomial> p, List<Polynomial> r) {
        if (p.size() == r.size()) {
            for (int i = 0; i < p.size(); i++) {
                if(p.get(i).getA() != r.get(i).getA() && p.get(i).getX() !=r.get(i).getX()){
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    public static int Meaning(List<Polynomial> p, int x) {
        int sum = 0;
        for(int i = 0; i<p.size(); i++){
            Polynomial part = p.get(i);
            int degree = (int)Math.pow(x,part.getX());
            sum+= degree*part.getA();
        }
        return sum;
    }
}
/**
 * @version Самая первая версия функции Add(p,q,r), извините, еще не очень умею пользоватся GitHub

if (q.size() == r.size()) {
for (int i = 0; i < q.size(); i++) {
if (q.get(i).getX() == r.get(i).getX()) {
Polynomial elem = new Polynomial(0, 0);
elem.setA(q.get(i).getA() + r.get(i).getA());
elem.setX(q.get(i).getX());
p.add(elem);
} else {
p.add(q.get(i));
p.add(r.get(i));
}
}
}
else {
int param = Math.min(q.size(), r.size());
for (int i = 0; i < param; i++) {
Polynomial elem = new Polynomial(0, 0);
if (q.get(i).getX() == r.get(i).getX()) {
elem.setA(q.get(i).getA() + r.get(i).getA());
p.add(elem);
} else {
p.add(q.get(i));
p.add(r.get(i));
}
}
for(int i = param; i<Math.max(q.size(), r.size()); i++ )
if(q.size()> r.size())
p.add(q.get(i));
else p.add(r.get(i));
}

 */