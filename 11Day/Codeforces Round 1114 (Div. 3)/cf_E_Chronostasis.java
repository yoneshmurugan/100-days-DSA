import java.io.*;
import java.util.*;

public class cf_E_Chronostasis {
    static class FS {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while(!st.hasMoreTokens())
                try {
                    String line=br.readLine();
                    if(line==null) return null;
                    st=new StringTokenizer(line);
                } catch (IOException e) {}
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }

    public static void main(String[] args) {
        FS in = new FS();
        String f = in.next();
        if(f==null)return;
        int t = Integer.parseInt(f);
        StringBuilder sb = new StringBuilder();
        
        while(t-->0) {
            int n = in.nextInt();
            TreeMap<Long,Integer> m = new TreeMap<>();
            long sum = 0;
            
            for(int i=0; i<n; i++){
                long v = in.nextLong();
                sum += v;
                m.put(v, m.getOrDefault(v,0)+1);
            }
            
            if(sum<=0){
                sb.append("-1\n");
                continue;
            }
            
            long cur=0;
            boolean ok=true;
            long[] a=new long[n];
            
            for(int i=0; i<n; i++){
                long req = 1-cur;
                Long best = m.ceilingKey(req);

                
                if(best==null){
                    ok=false; break;
                }
                
                cur+=best;
                a[i]=cur;
                
                int c = m.get(best);
                if(c==1) m.remove(best);
                else m.put(best, c-1);
            }
            
            if(!ok) sb.append("-1\n");
            else {
                for(int i=0; i<n; i++){
                    sb.append(a[i]).append(i==n-1?"":" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
