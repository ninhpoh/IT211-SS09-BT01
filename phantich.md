# Phân tích: Vì sao không dùng System.out.println() trên Production

- Không lưu trữ tập trung:
    - System.out.println() chỉ in ra console, khi server restart hoặc log bị xoá thì mất toàn bộ lịch sử lỗi.
    - Khó truy vết lỗi trên môi trường Production thực tế.

- Không phân cấp mức độ log:
    - Không thể phân biệt INFO, DEBUG, ERROR, WARN.
    - Gây khó khăn khi lọc log hoặc giám sát hệ thống.

- Không hỗ trợ đầy đủ stack trace và quản lý log:
    - e.printStackTrace() in lỗi trực tiếp ra console rất khó đọc.
    - Không tích hợp tốt với các hệ thống log chuyên nghiệp như ELK, Grafana, Splunk.
    - Khó tìm kiếm và phân tích nguyên nhân sự cố.