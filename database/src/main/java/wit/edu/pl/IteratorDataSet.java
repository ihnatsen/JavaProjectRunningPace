package wit.edu.pl;

import java.util.List;

public class IteratorDataSet<T> implements Iterator{
    List<T> items;
    int position = 0;

    public IteratorDataSet(List<T>items ) {
        this.items = items;

    }

    @Override
    public boolean hasHext() {

        return !(position >= items.size() || items.get(position) == null);
    }

    @Override
    public T next() {
        T str = items.get(position);
        position++;
        return str;
    }
}
