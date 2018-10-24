public class SuperArray {
  private String[] data;
  private int size;

  public SuperArray() {
    data = new String[10];
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
    if (x >= 0 && x < size) {
      return data[x];
    }
    else {
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
  
  public void add(int index,String a) {
	  if(index >= 0 && index < size) {
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
	  else {
		  System.out.println("Error");
	 }
  }
 
  public String set(int x, String a) {
    if (x >= 0 && x < size) {
      data[x] = a;
	  updateSize();
      return "Successfully set";
    }
    else {
      return null;
    }
  }
  
  public String remove(int index) {
	  if(index >= 0 && index < size) {
		  for(int i = index; i < data.length - 1; i++) {
			  data[i] = data[i+1];
		  }
		  data[data.length - 1] = null;
		  updateSize();
		  return "Successfully removed";
	  }
	  else {
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
    String[] newArray = new String[data.length * 2];
    for(int i = 0; i < data.length; i++) {
      newArray[i] = data[i];
    }
    data = newArray;
  }

}
