package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    int id = 0;
    ArrayList<Quotation> quotations = new ArrayList<>();

    void run() {
        System.out.println("== 명언 앱 ==");


        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            Rq rq = new Rq(cmd);

            switch (rq.getAction()) {
                case "종료":
                    return;
                case "등록":
                    actionWrite();
                    break;
                case "목록":
                    actionList();
                    break;
                case "삭제":
                    actionRemove(rq);
                    break;

            }
        }
    }




    void actionWrite() {
        System.out.print("명언: ");
        String content = scanner.nextLine();
        System.out.print("작가: ");
        String author = scanner.nextLine();
        id++;
        Quotation quotation = new Quotation(content, author, id);
        quotations.add(quotation);
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);
            System.out.println(quotation.id + " / " + quotation.author + " / " + quotation.content);
        }
    }

    void actionRemove(Rq rq) {
        int paramValue = rq.getParamAsInt("id", 0);
        if (paramValue == 0) {
            System.out.println("id를 정확하게 입력해주세요.");
            return;
        }

        int index = findIndexByParam(paramValue, 0);
        if (index == 0) {
            System.out.printf("%d번 명언이 존재하지 않습니다.\n", paramValue);
        }
        quotations.remove(index);
        System.out.println(paramValue + "번 명언이 삭제되었습니다.");
    }

    int findIndexByParam(int paramValue, int defaultValue) {
        for (int i = 0; i < quotations.size(); i++) {
            Quotation quotation = quotations.get(i);
            if (quotation.id == paramValue) {
                return i;
            }
        }
        return defaultValue;
    }
}





