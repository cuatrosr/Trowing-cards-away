

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    private static String discarded;
    private static String remaining;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            opDeck(n);
            bw.write(discarded);
            bw.write(remaining);
            n = Integer.parseInt(br.readLine());
        }
        bw.flush();
    }

    public static void opDeck(int n) {
        Queue<Integer> q = fillQueue(n);
        Stack<Integer> s = new Stack();

        discardCards(q, s);

        String remainingNum = q.toString().replaceAll("\\[", "").replaceAll("\\]", "");
        String discardArr = s.toString().replaceAll("\\[", "").replaceAll("\\]", "");

        setMsg(remainingNum, discardArr);
    }

    public static Queue<Integer> fillQueue(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        return q;
    }

    public static void discardCards(Queue<Integer> q, Stack<Integer> s) {
        while (q.size() != 1) {
            s.push(q.remove());
            int temp = q.remove();
            q.add(temp);
        }
    }

    public static void setMsg(String remainingNum, String discardArr) {
        discarded = "Discarded cards:";
        discarded += (discardArr.equals("")) ? "\n" : " " + discardArr + "\n";

        remaining = "Remaining card:";
        remaining += (remainingNum.equals("")) ? "\n" : " " + remainingNum + "\n";
    }
}
