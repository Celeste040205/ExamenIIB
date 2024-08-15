
codigo para que se copien los botones del menu de uno en uno

        GCbtnAlimenGeno.addActionListener(e -> {
            listModel.addElement(GCGenoAlimento.getText());
        });

        GCbtnAlimenNat.addActionListener(e -> {
            listModel.addElement(GCIngestaNativa.getText());
        }); 