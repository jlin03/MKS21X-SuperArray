public class SuperArray {
  private String[] data;
  private int size;

  public SuperArray() {
    data = new String[10];
	size = 0;
  }
  
  public SuperArray(int initial) {
	  data = new String[initial];
	  size = 0;
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

  public String get(int x) {
    try {
      indexCheck(x);
      return data[x];
    }
    catch(IndexOutOfBoundsException e) {
      System.out.println("Caught an error in get");
      return null;
    }
  }

  int indexOf(String a) {
	  int index = -1;
	  for(int i = 0; i < size; i++) {
		  if(data[i].equals(a)) {
			  index = i;
			  break;
		  }
	  }
	  return index;
  }

  int lastIndexOf(String a) {
	  int index = -1;
	  for(int i = size - 1; i >= 0; i--) {
		  if(data[i].equals(a)) {
			  index = i;
			  break;
		  }
	  }
	  return index;
  }

  public boolean contains(String a) {
	  for(int i = 0; i < size; i++) {
		  if(data[i].equals(a)) {
			  return true;
		  }
	  }
	  return false;
  }

  public void updateSize() {
    int count = 0;
    for(int i = 0; i < data.length; i++) {
      if(data[i] == null) {
		break;
      }
	  else {
		count += 1;
	  }
    }
	size = count;
  }

  public boolean isEmpty() {
    return(size == 0);
  }

  public boolean add(String a) {
    if(size < data.length && a != null) {
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

  public void add(int index,String a) {
    try {
        indexCheck(index);
        nullCheck(a);

		    if(size < data.length) {
			       for(int i = data.length - 1; i > index; i--) {
				           data[i] = data[i-1];
			       }
			       data[index] = a;
			       updateSize();
		    }
		    else {
			       resize();
			       this.add(index,a);
		    }
    }
    catch(IndexOutOfBoundsException | IllegalArgumentException e) {
      System.out.println("Caught an error in add");
    }
  }

  public String set(int x, String a) {
    try {
      indexCheck(x);
      nullCheck(a);
      data[x] = a;
	    updateSize();
      return "Successfully set";
    }
    catch(IndexOutOfBoundsException | IllegalArgumentException e) {
      System.out.println("Caught an error in set");
      return null;
    }
  }

  public String remove(int index) {
	  try {
      indexCheck(index);
		  for(int i = index; i < data.length - 1; i++) {
			  data[i] = data[i+1];
		  }
		  data[data.length - 1] = null;
		  updateSize();
		  return "Successfully removed";
	  }
	  catch(IndexOutOfBoundsException e) {
      System.out.println("Caught an error in remove");
		  return null;
	  }
  }

  public boolean remove(String a) {
	  int index = -1;
	  for(int i = 0; i < size; i++) {
		  if(data[i].equals(a)) {
			  index = i;
		  }
	  }
	  if(index != -1) {
		  this.remove(index);
		  return true;
	  }
	  else {
		  return false;
	  }
  }

  private void resize() {
    String[] newArray = new String[data.length * 2 + 1];
    for(int i = 0; i < data.length; i++) {
      newArray[i] = data[i];
    }
    data = newArray;
  }

  public void nullCheck(String a) {
    if(a == null) {
      throw new IllegalArgumentException();
    }
  }

  public void indexCheck(int index) {
    if(index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }

}
