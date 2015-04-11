package problem15;

public class CoOrd {
	int x;
	int y;
	
	public CoOrd(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof CoOrd)) {
			return false;
		} else {
			CoOrd c = (CoOrd) o;
			return ((this.x == c.x) && (this.y == c.y));
		}
	}
	
	@Override
	public int hashCode() {
		return (this.x * 17) + (this.y * 13);
	}
	
}
