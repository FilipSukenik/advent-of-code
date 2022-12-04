package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Analyzer15 {

    public void analyse(Map15 map) {

        Node15 startNode = map.getStart();
        Node15 endNode = map.getEnd();

        startNode.setDistance(0);

        List<Node15> toProcessNodes = new ArrayList<>();
        toProcessNodes.add(startNode);

        while (true) {

            Node15 actualNode = toProcessNodes.remove(0);
            if(actualNode.isVisited()){
                continue;
            }
            if (actualNode.equals(endNode)) {
                //TODO FINISH THIS
                System.out.println("found distance " + actualNode.getDistance());
                break;
            }
            actualNode.setVisited(true);
            List<Candidate15> candidates = actualNode.toCandidates();
            List<Node15> nodes = verifyCandidates(map, candidates);
            for (Node15 node : nodes) {
                node.addDistance(actualNode.getDistance());
                toProcessNodes.add(node);
            }

            toProcessNodes.sort(Comparator.comparingInt(Node15::getDistance));
        }
    }

    private List<Node15> verifyCandidates(Map15 map, List<Candidate15> candidates) {

        List<Node15> result = new ArrayList<>();
        for (Candidate15 candidate : candidates) {
            try {
                Node15 node = map.getCandidate(candidate);
                if (node.isVisited()) {
                    throw new RuntimeException();
                }
                result.add(node);
            } catch (Exception e) {

            }
        }
        return result;
    }
}
