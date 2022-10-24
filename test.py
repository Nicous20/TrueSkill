from Pics import Pics

a = Pics('a')
b = Pics('b')

print(a.get_rk())
print(b.get_rk())
Pics.win(a,b,-1)
print(a.rk.mu)

print(a.get_rk())
print(b.get_rk())