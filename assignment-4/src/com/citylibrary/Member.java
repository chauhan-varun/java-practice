package com.citylibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member {
    private final int memberId;
    private String name;
    private String email;
    private final List<Integer> issuedBooks; // stores book IDs

    public Member(int memberId, String name, String email) {
        this(memberId, name, email, new ArrayList<>());
    }

    public Member(int memberId, String name, String email, List<Integer> issuedBooks) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.issuedBooks = new ArrayList<>(issuedBooks);
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getIssuedBooks() {
        return issuedBooks;
    }

    public void addIssuedBook(int bookId) {
        if (!issuedBooks.contains(bookId)) {
            issuedBooks.add(bookId);
        }
    }

    public void returnIssuedBook(int bookId) {
        issuedBooks.remove((Integer) bookId);
    }

    public void displayMemberDetails() {
        System.out.printf("ID: %d | Name: %s | Email: %s | Issued Books: %s%n",
                memberId, name, email, issuedBooks);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", issuedBooks=" + issuedBooks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }

    public String toDataLine() {
        return memberId + "|" + escape(name) + "|" + escape(email) + "|" + serializeIssued();
    }

    public static Member fromDataLine(String line) {
        String[] parts = line.split("\\|", -1);
        if (parts.length < 4) throw new IllegalArgumentException("Invalid member line: " + line);
        int id = Integer.parseInt(parts[0]);
        String name = unescape(parts[1]);
        String email = unescape(parts[2]);
        List<Integer> issued = new ArrayList<>();
        if (!parts[3].isEmpty()) {
            String[] ids = parts[3].split(",");
            for (String s : ids) {
                if (!s.isBlank()) issued.add(Integer.parseInt(s.trim()));
            }
        }
        return new Member(id, name, email, issued);
    }

    private String serializeIssued() {
        if (issuedBooks.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < issuedBooks.size(); i++) {
            if (i > 0) sb.append(',');
            sb.append(issuedBooks.get(i));
        }
        return sb.toString();
    }

    private static String escape(String s) {
        return s == null ? "" : s.replace("|", "\u2758");
    }

    private static String unescape(String s) {
        return s == null ? "" : s.replace("\u2758", "|");
    }
}
