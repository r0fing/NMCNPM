select i.id, itemName, sum(quantity) as quantity_sold, sum(itemPrice * quantity) as revenue
from tblItem i
join tblInvoiceItem ii on ii.tblItemid=i.id
join tblInvoice inv on ii.tblInvoiceid=inv.id and dateIssue between '2025-01-20' and '2025-01-22'
group by i.id
order by revenue desc;