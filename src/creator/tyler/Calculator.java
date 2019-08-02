package creator.tyler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator
{
    public void calculate()

    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ultimate calculator! What would you like to calculate?");
        System.out.println("a = basic arithmetic expressions");
        String determinate = scanner.next();

        if (determinate.toLowerCase().equals("a"))
        {
            List<Integer> intList = new ArrayList<>();
            List<String> stringList = new ArrayList<>();

            System.out.println("Enter an expression:");
            int a = scanner.nextInt();
            intList.add(0, a);
            String sign = scanner.next();
            stringList.add(0, sign);
            int count = 0;
            while (!sign.equals("="))
            {
                count++;
                int b = scanner.nextInt();
                sign = scanner.next();
                intList.add(count, b);
                stringList.add(count, sign);
            }

            for (int i = 0; i < intList.size(); i++)
            {
                if (stringList.get(i).equals("+"))
                    a += intList.get(i + 1);
                else if (stringList.get(i).equals("-"))
                    a -= intList.get(i + 1);
                else if (stringList.get(i).equals("*"))
                    a *= intList.get(i + 1);
                else if (stringList.get(i).equals("/"))
                {
                    if (intList.get(i + 1) == 0)
                    {
                        System.out.println("Error: Cannot divide by 0.");
                    }
                    a /= intList.get(i + 1);
                }
                else if (stringList.get(i).equals("^"))
                {
                    for (int j = 1; j < intList.get(i + 1); j++)
                    {
                        a *= intList.get(i);
                    }
                }
                else if (stringList.get(i).equals("="))
                    break;
                else
                {
                    System.out.println("Syntax Error");
                    return;
                }
            }
            System.out.println(a);

            try
            {
                a /= 0;
            }
            catch (Exception e)
            {
                System.out.println("Oops, there was a error, you goof!");
            }
        }
    }
}
