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

  public void updateSize() {
    int count = 0;
    for(int i = 0; i < data.length; i++) {
      if(data[i] == null) {
        return count;
      }
      count += 1;
    }
  }

  public boolean isEmpty() {
    return(size == 0);
  }

  public boolean add(String a) {
    if(size < data.length) {
      data[size] = a;
      updateSize();
      return true;
    }
    else {
      resize();
      data[size] = a;
      updateSize();
      return true;
    }
  }

  public String get(int x) {
    if (x >= 0 && x < size) {
      return data[x];
    }
    else {
      return null;
    }
  }

  public String set(int x, String a) {
    if (x >= 0 && x < size) {
      data[x] = a;
        return "Successfully set";
    }
    else {
      return null;
    }
  }

  private void resize() {
    String[] oldArray = new String[data.length * 2 + 1];
    for(int i = 0; i < data.length; i++) {
      oldArray[i] = data[i];
    }
    data = oldArray;
  }

  









}
