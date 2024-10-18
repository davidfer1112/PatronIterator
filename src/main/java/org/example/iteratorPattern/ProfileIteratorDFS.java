package org.example.iteratorPattern;

import org.example.entities.SocialNetworkProfile;
import org.example.entities.UserProfile;


import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ProfileIteratorDFS implements ProfileIterator<SocialNetworkProfile> {

    private Set<SocialNetworkProfile> visited;
    private Deque<SocialNetworkProfile> toVisit;

    public ProfileIteratorDFS(SocialNetworkProfile entryPoint) {
        visited = new HashSet<>();
        toVisit = new LinkedList<>();
        toVisit.push(entryPoint); // Utiliza una pila para DFS
    }

    @Override
    public SocialNetworkProfile getNext() {
        if (toVisit.isEmpty()) return null;

        SocialNetworkProfile next = toVisit.pop();
        if (next instanceof UserProfile user) {
            user.getFollowing().stream()
                    .filter(profile -> !visited.contains(profile))
                    .forEach(toVisit::push); // Agrega en profundidad
        }
        visited.add(next);
        return next;
    }

    @Override
    public boolean hasNext() {
        return !toVisit.isEmpty();
    }
}
