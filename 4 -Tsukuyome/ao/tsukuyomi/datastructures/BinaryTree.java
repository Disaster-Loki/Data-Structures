package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.objects.Skill;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private No raiz;
    private List<Skill> skills;

    public BinaryTree() {
        this.raiz = null;
        this.skills = new ArrayList<>();
    }

    public void createSkill(Skill skill) {
        if (checkDuplicateSkill(skill)) {
            System.out.println("A skill with the same name already exists.");
            return;
        }

        skills.add(skill);

        No novoNode = new No(skill.getLevel());
        novoNode.setSkill(skill.getName());

        if (raiz == null) {
            raiz = novoNode;
        } else {
            adicionarNoRecursivo(raiz, novoNode);
        }
    }

    private void adicionarNoRecursivo(No currentNode, No novoNode) {
        if (novoNode.getValor() < currentNode.getValor()) {
            if (currentNode.getEsquerda() == null) {
                currentNode.setEsquerda(novoNode);
            } else {
                adicionarNoRecursivo(currentNode.getEsquerda(), novoNode);
            }
        } else if (novoNode.getValor() > currentNode.getValor()) {
            if (currentNode.getDireita() == null) {
                currentNode.setDireita(novoNode);
            } else {
                adicionarNoRecursivo(currentNode.getDireita(), novoNode);
            }
        } else {
            currentNode.setSkill(novoNode.getSkill()); // Define a habilidade do nó
        }
    }

    public void removerNode(int valor) {
        raiz = removerNodeRecursivo(raiz, valor);
    }

    private No removerNodeRecursivo(No currentNode, int valor) {
        if (currentNode == null) {
            return null;
        }

        if (valor == currentNode.getValor()) {
            if (currentNode.getEsquerda() == null && currentNode.getDireita() == null) {
                return null;
            } else if (currentNode.getEsquerda() == null) {
                return currentNode.getDireita();
            } else if (currentNode.getDireita() == null) {
                return currentNode.getEsquerda();
            } else {
                int menorValor = encontrarMenorValor(currentNode.getDireita());
                currentNode.setValor(menorValor);
                currentNode.setDireita(removerNodeRecursivo(currentNode.getDireita(), menorValor));
                return currentNode;
            }
        }
        if (valor < currentNode.getValor()) {
            currentNode.setEsquerda(removerNodeRecursivo(currentNode.getEsquerda(), valor));
            return currentNode;
        }
        currentNode.setDireita(removerNodeRecursivo(currentNode.getDireita(), valor));
        return currentNode;
    }

    private int encontrarMenorValor(No currentNode) {
        return currentNode.getEsquerda() == null ? currentNode.getValor() : encontrarMenorValor(currentNode.getEsquerda());
    }

    public void listarNodes() {
        listarNodesRecursivo(raiz);
    }

    private void listarNodesRecursivo(No currentNode) {
        if (currentNode != null) {
            listarNodesRecursivo(currentNode.getEsquerda());
            System.out.println("Level: " + currentNode.getValor() + " - Skill: " + currentNode.getSkill());
            listarNodesRecursivo(currentNode.getDireita());
        }
    }

    public void showFullTree() {
        System.out.println("Skill Tree:");
        showFullTreeRecursivo(raiz, 0);
    }

    private void showFullTreeRecursivo(No currentNode, int nivel) {
        if (currentNode != null) {
            showFullTreeRecursivo(currentNode.getDireita(), nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("\t");
            }
            System.out.println("Level: " + currentNode.getValor() + "- Skill: " + currentNode.getSkill());
            showFullTreeRecursivo(currentNode.getEsquerda(), nivel + 1);
        }
    }

    public void showLevels() {
        System.out.println("Skill Levels:");
        showLevelsRecursivo(raiz, 0);
    }

    private void showLevelsRecursivo(No currentNode, int nivel) {
        if (currentNode != null) {
            showLevelsRecursivo(currentNode.getEsquerda(), nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("\t");
            }
            System.out.println("Level: " + currentNode.getValor());
            showLevelsRecursivo(currentNode.getDireita(), nivel + 1);
        }
    }

    public void showSkill() {
        System.out.println("Skills:");
        for (Skill skill : skills) {
            System.out.println(skill.getName());
        }
    }

    public void searchSkill(String nome) {
        boolean encontrada = false;

        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(nome)) {
                encontrada = true;
                System.out.println("\n================================");
                System.out.println("Skill Name: " + skill.getName());
                System.out.println("Description: " + skill.getDescription());
                System.out.println("Level: " + skill.getLevel());
                System.out.println("================================");
                break;
            }
        }
        if (!encontrada) {
            System.out.println("Skill not found.");
        }
    }

    public void removeAllSkill() {
        raiz = null;
        skills.clear();
    }

    private boolean checkDuplicateSkill(Skill newSkill) {
        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(newSkill.getName())) {
                return true;
            }
        }
        return false;
    }
}