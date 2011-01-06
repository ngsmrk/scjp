/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scjp.maps;

/**
 *
 * @author Angus
 */
public class TestKey implements Comparable {
    private String value;

    public TestKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TestKey other = (TestKey) obj;
        if ((this.value == null) ? (other.value != null) : !this.value.equals(other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }

    public int compareTo(Object o) {

        if (o instanceof TestKey) {
            return this.value.compareTo(((TestKey)o).value);
        }

        return -1;
    }

    @Override
    public String toString() {
        return "TestKey{" + "value=" + value + '}';
    }
    
}
