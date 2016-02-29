import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by wsdevotion on 16/2/29.
 */
public class Compare implements Comparable {

    private int id;

    private String name;

    public Compare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        } else if (o != null && o instanceof Compare) {
            Compare compare = (Compare) o;
            if (id <= compare.getId()) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }

    private static final Comparator<Compare> COMPARATOR = new Comparator<Compare>() {
        public int compare(Compare o1, Compare o2) {
            return o1.compareTo(o2);//运用Compare类的compareTo方法比较两个对象
        }
    };

    public static void main(String[] args) {
        ArrayList<Compare> student = new ArrayList<Compare>();
        Compare compare1 = new Compare(4, "yueliming");
        Compare compare2 = new Compare(3, "yueliming");

        student.add(compare1);
        student.add(compare2);

        Collections.sort(student, COMPARATOR);//用我们写好的Comparator对student进行排序
        for (int i = 0; i < student.size(); i++) {
            System.out.println(student.get(i).getId());
        }
    }


}
