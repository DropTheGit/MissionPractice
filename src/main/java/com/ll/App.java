package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    int id = 0;
    ArrayList<Quotation> quotations = new ArrayList<>();

    void run() {
        System.out.println("== 명언 앱 ==");

        write();


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
                case "수정" :
                    actionModify(rq);
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

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
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

        int index = findIndexByParam(paramValue, -1);
        if (index == -1) {
            System.out.printf("%d번 명언이 존재하지 않습니다.\n", paramValue);
            return;
        }
        quotations.remove(index);
        System.out.println(paramValue + "번 명언이 삭제되었습니다.");
    }

    void actionModify(Rq rq) {
        int paramValue = rq.getParamAsInt("id", 0);
        if (paramValue == 0) {
            System.out.println("id를 정확하게 입력해주세요.");
            return;
        }

        int index = findIndexByParam(paramValue, -1);
        if (index == -1) {
            System.out.printf("%d번 명언이 존재하지 않습니다.\n", paramValue);
            return;
        }
        Quotation quotation = quotations.get(index);
        System.out.println("명언(기존) : " + quotation.content);
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.println("작가(기존) : " + quotation.author);
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        quotation.content = content;
        quotation.author = author;

        System.out.printf("%d번 명언이 수정되었습니다.\n", paramValue);
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

    void write(){
        for (int i = 1; i < 11; i++) {
            Quotation quotation = new Quotation("명언"+i, "작가"+i, i);
            id++;
            quotations.add(quotation);
        }
    }

}





