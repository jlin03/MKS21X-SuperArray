public class SuperArray {
  private String[] data;
  private int size;

  public SuperArray() {
    data = new String[10];
  }

  public String toString() {
    String out = "[";
    for(int i = 0; i < data.length - 1;i++) {
      out += data[i] + ",";
    }
    out += data[data.length - 1] + "]";
    return out;
  }

  public void clear() {
    for(int i = 0; i < data.length;i++) {
      data[i] = null;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return(size == 0);
  }

  public boolean add(String a) {
    if(size == data.length) {
      data[size] = a;
      return true;
    }
    else {
      return false;
    }
  }

  public String get(int x) {
    if (x >= 0 && x < data.length) {
      return data[x];
    }
    else {
      return null;
    }
  }

  public String set(int x, String a) {
    if (x >= 0 && x < data.length) {
      data[x] = a;
        return "Successfully set";
    }
    else {
      return null;
    }
  }

  private void resize() {
    String[] oldArray = new String[data.length + 10];
    for(int i = 0; i < data.length; i++) {
      oldArray[i] = data[i];
    }
    String[] data = new String[data.length + 10];
    data = oldArray;

  }







}
