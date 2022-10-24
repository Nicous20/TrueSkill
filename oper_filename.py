import os
import shutil


from Pics import Pics
from trueskill import Rating, quality_1vs1, rate_1vs1
import MySQLdb

db = MySQLdb.connect(
    host="dev.metattri.com",    # 主机名
    user="root",         # 用户名
    passwd="xbz123456",  # 密码
    db="true_skill",
    port=3308)

cur = db.cursor()
sql = "INSERT INTO `ItemId` values (%s, %s, %s, %s, %s)"

dic = "Training Set 2"
folder_ls = list(filter(lambda x : x.find('Store') == -1, os.listdir(dic)))
to_dic = "Set"
if not os.path.exists(to_dic):
    os.mkdir(to_dic)

folder_idx = 0
for folder in folder_ls:
    new_folder_path = os.path.join(to_dic, str(folder_idx))
    os.mkdir(new_folder_path)
    img_idx = 0
    img_ls = os.listdir(os.path.join(dic, folder))
    cur.execute(sql, (folder, folder_idx, img_ls[0], img_ls[1], img_ls[2]))
    db.commit()
    for img in img_ls:
        src = os.path.join(os.path.join(dic, folder), img)
        dst = os.path.join(new_folder_path, str(img_idx)+'.jpg')
        shutil.copy(src, dst)
        db.commit()
        img_idx = img_idx + 1

    folder_idx += 1

db.close()

