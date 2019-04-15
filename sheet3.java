package eg.edu.alexu.csd.datastructure.iceHockey;
import java.awt.*;
import java.awt.List;
import java.util.*;
class comparator implements Comparator<Point>{
	public int compare(Point p1, Point p2) {
		if(p1.x != p2.x) {
			return p1.x - p2.x;
		}
		return p1.y - p2.y;
	}
	
}
public class findPlayer implements IPlayersFinder{
	private String[] photo;
	private int team;
	private int threshold;
	public static Point ans1 = new Point();
	public static Point ans2 = new Point();
	public static int counter;
	public findPlayer(String[] p, int t, int thres) {
		photo = p;
		team = t;
		threshold = thres;
	}
	
    public static Point [] findPlayers (String[] photo, int team, int threshold){
    	if(photo.length == 0)
    		return ;
    	boolean arr[][] = new boolean[photo.length][photo[0].length()];
    	for (int i = 0; i < photo.length; ++i) {
    		for(int j = 0; j < photo[i].length(); ++j) {
    			if(photo[i].charAt(j)-'0' == team)
    				arr[i][j] = true;
    		}
    	}
    	ArrayList<Point> ans = new ArrayList<Point>();
    	for(int i = 0; i < photo.length; ++i) {
    		for(int j = 0; j < photo[0].length(); ++j) {
    			counter = 0;
    			if(arr[i][j] == true) {
    				arr[i][j] = false;
    				ans1.move(i, j);
    		    	ans2.move(i, j);
    		    	counter ++;
    		    	search(arr, i, j);
    		    	
    		    	if(counter*4 >= threshold) {
    		    		int xx= ans1.x + ans2.x + 1;
    		    		int yy = ans1.y + ans2.y + 1;
    		    		Point b = new Point(yy, xx);
    		    		ans.add(b);
    		    	}
    			}
    		}
    	}
    	Point answer[] = new Point[ans.size()];
    	ans.toArray(answer);
		Arrays.sort(answer, new comparator());
		return answer;
    }
    public static int search(boolean arr[][], int x, int y) {
    	
    	if(x+1 < arr.length && arr[x+1][y] == true) {
    		arr[x+1][y]=false;
    		counter++;
    		int z = Math.max(ans1.x, x+1);
    		ans1.x=z;
    		search(arr, x+1, y);
    	}
    	if(x-1 >= 0 && arr[x-1][y] == true) {
    		arr[x-1][y]=false;
    		counter ++;
    		int z = Math.min(ans2.x, x-1);
    		ans2.x=z;
    		search(arr, x-1, y);
    	}
    	if(y+1 < arr[0].length && arr[x][y+1] == true) {
    		arr[x][y+1]=false;
    		counter ++;
    		int z = Math.max(ans1.y, y+1);
    		ans1.y = z;
    		search(arr, x, y+1);
    	}
    	if(y-1 >= 0 && arr[x][y-1] == true) {
    		arr[x][y-1]=false;
    		counter ++;
    		int z = Math.min(ans2.y, y-1);
    		ans2.y = z;
    		search(arr, x, y-1);
    	}
    	return counter;
    }
    public static void main(String args[]) {
    	String p[] = {};
    	
    	Point ans[] = findPlayers(p, 8, 9);
    	for(int i = 0; i < ans.length; ++i) {
    		System.out.println(ans[i].x + " " + ans[i].y);
    	}
    }
}
