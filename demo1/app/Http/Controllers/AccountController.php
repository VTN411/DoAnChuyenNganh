<?php

namespace App\Http\Controllers;

use App\Models\Account;
use Illuminate\Http\Request;

class AccountController extends Controller
{
    public function index()
    {
        $accounts = Account::all();
        return response()->json($accounts);
    }

    // Hiển thị form tạo mới tài khoản
    public function create()
    {
        //
    }

    // Lưu tài khoản mới vào cơ sở dữ liệu
    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required|string|max:255',
            'email' => 'required|string|email|max:255|unique:accounts',
            'password' => 'required|string|min:8',
        ]);

        $account = Account::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => $request->password,
        ]);

        return response()->json($account, 201);
    }

    // Hiển thị một tài khoản
    public function show($id)
    {
        $account = Account::findOrFail($id);
        return response()->json($account);
    }

    // Hiển thị form chỉnh sửa tài khoản
    public function edit($id)
    {
        //
    }

    // Cập nhật thông tin tài khoản
    public function update(Request $request, $id)
    {
        $account = Account::findOrFail($id);

        $request->validate([
            'name' => 'string|max:255',
            'email' => 'string|email|max:255|unique:accounts,email,' . $account->id,
            'password' => 'string|min:8',
        ]);

        $account->update([
            'name' => $request->name ?? $account->name,
            'email' => $request->email ?? $account->email,
            'password' => $request->password ?? $account->password,
        ]);

        return response()->json($account);
    }

    // Xóa tài khoản
    public function destroy($id)
    {
        $account = Account::findOrFail($id);
        $account->delete();
        return response()->json(null, 204);
    }
}
