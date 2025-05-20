SELECT 
  tI.id, 
  itemName, 
  itemDescription, 
  COALESCE(SUM(CASE 
    WHEN dateIssue BETWEEN '2025-01-20' AND '2025-01-22' THEN quantity 
    ELSE 0 END), 0) AS quantity_sold, 
  COALESCE(SUM(CASE 
    WHEN dateIssue BETWEEN '2025-01-20' AND '2025-01-22' THEN quantity * itemPrice 
    ELSE 0 END), 0) AS revenue
FROM tblItem tI
LEFT JOIN tblInvoiceItem tII 
  ON tII.tblItemid = tI.id
LEFT JOIN tblInvoice tInv 
  ON tInv.id = tII.tblInvoiceid
GROUP BY tI.id, itemName, itemDescription
ORDER BY revenue DESC;
