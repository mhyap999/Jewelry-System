
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Sales extends javax.swing.JDialog {

    public static int custID;

    public Sales() {
        initComponents();
        setLocationRelativeTo(this);
    }

    private DefaultTableModel FillStoreTable() {
        String[] columnNames = {"ID", "Product Name", "Weight(g)", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 2:
                        return Double.class;
                    default:
                        return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                switch (col) {
                    default:
                        return false;
                }
            }
        };
        tblStore.setModel(tableModel);
        Object rowData[] = new Object[4];

        for (int i = 0; i < Store.products.size(); i++) {
            rowData[0] = Store.products.get(i).getProductID();
            rowData[1] = Store.products.get(i).getProductName();
            rowData[2] = Store.products.get(i).getWeight();
            rowData[3] = Product.convertTwoDecimalPoint(Store.products.get(i).calculateSellPrice());
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    private DefaultTableModel FillCustomerTable() {
        String[] columnNames = {"ID", "Product Name", "Weight(g)", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 2:
                        return Double.class;
                    default:
                        return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                switch (col) {
                    default:
                        return false;
                }
            }
        };
        tblCustomer.setModel(tableModel);
        Object rowData[] = new Object[4];
        Customer c = Customer.findCustomer(custID);
        if (c.showAllProducts() != null) {
            for (int i = 0; i < c.showAllProducts().size(); i++) {
                rowData[0] = c.showAllProducts().get(i).getProductID();
                rowData[1] = c.showAllProducts().get(i).getProductName();
                rowData[2] = c.showAllProducts().get(i).getWeight();
                rowData[3] = Product.convertTwoDecimalPoint(c.showAllProducts().get(i).calculateSellPrice());
                tableModel.addRow(rowData);
            }
        }
        return tableModel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        grp1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStore = new javax.swing.JTable();
        btnBuy = new javax.swing.JButton();
        btnSell = new javax.swing.JButton();
        btnExchange = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        btnPay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Store"));

        tblStore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblStore.getTableHeader().setReorderingAllowed(false);
        tblStore.setModel(FillStoreTable());
        jScrollPane1.setViewportView(tblStore);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        btnBuy.setText("Buy From");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        btnSell.setText("Sell To");
        btnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellActionPerformed(evt);
            }
        });

        btnExchange.setText("Exchange");
        btnExchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExchangeActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer"));

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCustomer.setModel(FillCustomerTable());
        tblCustomer.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblCustomer);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExchange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btnSell)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExchange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPay)
                        .addGap(16, 16, 16))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (tblStore.getSelectedRowCount() > 0) {

            DefaultTableModel storeModel = (DefaultTableModel) tblStore.getModel();
            DefaultTableModel customerModel = (DefaultTableModel) tblCustomer.getModel();

            int pID = (Integer) storeModel.getValueAt(tblStore.getSelectedRow(), 0);
            String pName = storeModel.getValueAt(tblStore.getSelectedRow(), 1).toString();
            double price = (Double) storeModel.getValueAt(tblStore.getSelectedRow(), 2);
//        double sellPrice = Double.parseDouble(storeModel.getValueAt(tblStore.getSelectedRow(), 3).toString());

            Product p = Store.findProduct(pID);
            customerModel.addRow(new Object[]{pID, pName, price, Product.convertTwoDecimalPoint(p.calculateSellPrice())});

            UJS.customers.get(custID).buyProduct(Store.findProduct(pID));
            Store.removeProduct(pID);
            storeModel.removeRow(tblStore.getSelectedRow());
        }
    }                                       

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {                                       
        StringBuilder sb = new StringBuilder();

        double total = 0;
        for (int i = 0; i < tblCustomer.getRowCount(); i++) {
            double weight = Double.parseDouble(tblCustomer.getValueAt(i, 2).toString());
            double price = Double.parseDouble(tblCustomer.getValueAt(i, 3).toString());
            double t = weight * price;
            sb.append(tblCustomer.getValueAt(i, 1));
            sb.append(" | ");
            sb.append(tblCustomer.getValueAt(i, 2));
            sb.append(" * ");
            sb.append(tblCustomer.getValueAt(i, 3));
            sb.append(" = RM " + Product.convertTwoDecimalPoint(t));
            sb.append("\n");
            total += t;
        }
        sb.append("\n---------------------------");
        sb.append("\n");
        sb.append("Total Price: RM " + Product.convertTwoDecimalPoint(total));
        double input = Double.parseDouble(JOptionPane.showInputDialog(null, "Receipt\n---------------------------\n" + sb, "Receipt", JOptionPane.INFORMATION_MESSAGE));
        double balance = input - total;
        JOptionPane.showMessageDialog(null, "Balance: RM " + Product.convertTwoDecimalPoint(balance));
    }                                      

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (tblCustomer.getSelectedRowCount() > 0) {
            DefaultTableModel customerModel = (DefaultTableModel) tblCustomer.getModel();
            DefaultTableModel storeModel = (DefaultTableModel) tblStore.getModel();

            int pID = (Integer) customerModel.getValueAt(tblCustomer.getSelectedRow(), 0);
            String pName = customerModel.getValueAt(tblCustomer.getSelectedRow(), 1).toString();
            double price = (Double) customerModel.getValueAt(tblCustomer.getSelectedRow(), 2);
            //        double sellPrice = Double.parseDouble(customerModel.getValueAt(tblCustomer.getSelectedRow(), 3).toString());

            Customer c = UJS.customers.get(custID);
            Product p = c.findProduct(pID);
            storeModel.addRow(new Object[]{pID, pName, price, Product.convertTwoDecimalPoint(p.calculatePurchasePrice())});

            Store.addProduct(p);
            c.sellProduct(p);
            customerModel.removeRow(tblCustomer.getSelectedRow());
        }
    }                                      

    private void btnExchangeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (tblCustomer.getSelectedRowCount() > 0 && tblStore.getSelectedRowCount() > 0) {

            DefaultTableModel storeModel = (DefaultTableModel) tblStore.getModel();
            DefaultTableModel customerModel = (DefaultTableModel) tblCustomer.getModel();

            int pID = (Integer) storeModel.getValueAt(tblStore.getSelectedRow(), 0);
            String pName = storeModel.getValueAt(tblStore.getSelectedRow(), 1).toString();
            double price = (Double) storeModel.getValueAt(tblStore.getSelectedRow(), 2);
            double sellPrice = Double.parseDouble(storeModel.getValueAt(tblStore.getSelectedRow(), 3).toString());

            customerModel.addRow(new Object[]{pID, pName, price, sellPrice});

            int pID1 = (Integer) customerModel.getValueAt(tblCustomer.getSelectedRow(), 0);
            String pName1 = customerModel.getValueAt(tblCustomer.getSelectedRow(), 1).toString();
            double price1 = (Double) customerModel.getValueAt(tblCustomer.getSelectedRow(), 2);
            double sellPrice1 = Double.parseDouble(customerModel.getValueAt(tblCustomer.getSelectedRow(), 3).toString());

            storeModel.addRow(new Object[]{pID1, pName1, price1, sellPrice1});

            //Exchange product
            Customer c = UJS.customers.get(custID);//Locate the index of the customer
            Product oldProduct = c.findProduct(pID1);//find the old product from inside customer c

            Product newProduct = Store.findProduct(pID);//Find the new product from Store using product id

            int indexOfOldProduct = c.products.indexOf(oldProduct);//Find the index of the oldProduct from product list in customer c
            int indexOfNewProduct = Store.products.indexOf(newProduct);//Find the index of the newProduct from product list in Store

            c.products.set(indexOfOldProduct, newProduct);//Overwrite or set the newProduct to the customer c
            Store.products.set(indexOfNewProduct, oldProduct);//Overwrite or set the oldProduct to the Store

            storeModel.removeRow(tblStore.getSelectedRow());
            customerModel.removeRow(tblCustomer.getSelectedRow());
        }
    }                                           

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnExchange;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnSell;
    private javax.swing.ButtonGroup grp1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTable tblStore;
    // End of variables declaration                   
}
