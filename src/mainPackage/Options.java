package mainPackage;

public interface Options<E>{
   void add(E elem);
   E get(int index);
   int size();
   void set(E elem, int index);
   boolean IsEmpty();
   void clear();
   void remove(int index);
}
