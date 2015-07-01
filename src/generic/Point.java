package generic;

/**
 * ����
 */
public class Point<T> {//����һ�����ʱ��,����T����ʾһ������,������ʾռλ��;,���Ǵ�ʱ�����������δȷ��,ʹ�õ�ʱ���ȷ��
	
	private T x;
	private T y;
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
}
