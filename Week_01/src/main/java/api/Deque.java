package api;

/**
 * 使用add first或者add last改写deque的API
 *
 * @author bingjie.chen
 * @date 2020/7/8
 */
public class Deque {
     Deque<String> deque=new LinkedList<String>();
        deque.addFirst("c");
        deque.addLast("b");
        deque.addLast("a");
        System.out.println(deque);

        String str=deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size()>0){
            System.out.println(deque.pop());
        }
        System.out.println(deque);

}
