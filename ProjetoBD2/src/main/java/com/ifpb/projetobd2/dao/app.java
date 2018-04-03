package com.ifpb.projetobd2.dao;

public class app {

    public static void main(String[] args) {
        TopicoDaoMongo dao = new TopicoDaoMongo();
        dao.buscar("flavio@gmail.com");
    }
}
