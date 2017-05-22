package exos.lujan.jose.joselujanexos.model;

/**
 * Created by Quezacoo on 5/21/2017.
 */


import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;

@Default(value = DefaultType.FIELD)
final class MyObject {
    @Element private String message;
    @Element private int count;

    public MyObject() {
    }

    public MyObject(String message, int count) {
        this.message = message;
        this.count = count;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override public int hashCode() {
        int result = 1;
        result = result * 31 + count;
        result = result * 31 + (message == null ? 0 : message.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof MyObject)) return false;
        MyObject other = (MyObject) obj;
        return count == other.count
                && (message == null ? other.message == null : message.equals(other.message));
    }
}
